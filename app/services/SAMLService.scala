package services

import javax.inject.Inject
import model.AuthnRequest
import repositories.{ClientRepository, IdpRepository}
import scalaz.zio.Task

class SAMLService @Inject()(
    clientRepository: ClientRepository,
    idpRepository: IdpRepository
) {
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
    } yield
      AuthnRequest(
        client.name,
        idp.destinationUrl,
        authnRequest,
        redirectUri
      )
  }

  private def mkAuthnRequest(): String = {
    views.xml.authn().body
    // Build twirl template
  }
}
