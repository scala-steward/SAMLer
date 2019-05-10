![Build Status](https://travis-ci.org/henricook/SAMLer.svg?branch=master) 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a3ed9505a475400ba2dff149f3fc8192)](https://app.codacy.com/app/henricook/SAMLer?utm_source=github.com&utm_medium=referral&utm_content=henricook/SAMLer&utm_campaign=Badge_Grade_Dashboard)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# This project is currently under construction

## SAMLer
SAMLer is an API-driven, Scala, Play Framework service designed to act as an SP (Server Provider) in SAML 2.0 flows to many IDPs (Identity Providers).

### Example Use cases
If your application has many businesses that would like to use Single Sign-on flows via SAML2 you need a piece of software to act as a Service Provider and authenticate your users via the respective IDPs. 

### Available actions

#### Must have
  - CRUD an IDP (authenticated for administrators)
  - OAuth /authorize to initiate IDP sign in flow (SP-initiated login)
  - Assertion Consumer Service (ACS) endpoint to respond to login-result POSTs from IDPs and redirect the user back to the application
  - Error logs of all exchanges

#### Could have
  - Lock IDPs to certain domain name(s)
  - Find IDP based on domain name(s)

#### Might be nice
  - Retrievable/Searchable audit logs of all exchanges

### Stack

  - Scala / Play Framework
  - Postgres (IDP persistence)

