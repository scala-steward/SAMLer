package repositories

import javax.inject.Inject
import model.Idp
import zio.Task

class IdpRepository @Inject()() {
  def getIdp(id: String, clientId: String): Task[Idp] =
    Task.succeed(
      Idp(
        id,
        clientId,
        "https://accounts.google.com/o/saml2/idp?idpid=C016hy8ou" // TODO: Store as Uri
      )
    )
}
