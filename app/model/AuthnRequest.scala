package model

case class AuthnRequest(
    clientName: String,
    destinationUrl: String,
    samlRequest: String,
    postAuthUrl: String
)
