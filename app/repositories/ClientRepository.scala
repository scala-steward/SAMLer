package repositories

import javax.inject.Inject
import model.Client
import scalaz.zio.Task

class ClientRepository @Inject()() {
  def getClient(clientId: String): Task[Client] =
    Task.succeed(Client(clientId, "Test Client 1"))
}
