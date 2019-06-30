package services

import java.net.URLEncoder
import java.util.Base64

import javax.inject.Inject
import model.AuthnRequest
import play.api.{Logger, Logging}
import repositories.{ClientRepository, IdpRepository}
import zio.Task

class SAMLService @Inject()(
    clientRepository: ClientRepository,
    idpRepository: IdpRepository
) extends Logging {
  def buildAuthnRequest(
      clientId: String,
      idpId: String,
      response_type: String,
      scope: String,
      nonce: String,
      redirectUri: String,
      state: String
  ): Task[AuthnRequest] = {

    for {
      client <- clientRepository.getClient(clientId)
      idp <- idpRepository.getIdp(client.id, idpId)
      authnRequest = mkAuthnRequest()
      _ = logger.warn("=== Authn contents = " + authnRequest)
    } yield
      AuthnRequest(
        client.name,
        idp.destinationUrl,
        authnRequest,
        redirectUri
      )
  }

  // Notes: Sign request here?
  private def mkAuthnRequest(): String = {
    val templateContent = views.xml.authn().body
    Base64.getEncoder.encodeToString(templateContent.getBytes("UTF-8"))
  }
}
