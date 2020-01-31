# SAMLer ![Build Status](https://travis-ci.org/henricook/SAMLer.svg?branch=master) 
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a3ed9505a475400ba2dff149f3fc8192)](https://app.codacy.com/app/henricook/SAMLer?utm_source=github.com&utm_medium=referral&utm_content=henricook/SAMLer&utm_campaign=Badge_Grade_Dashboard)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![HitCount](http://hits.dwyl.com/henricook/SAMLer.svg)](http://hits.dwyl.com/henricook/SAMLer)
[![GitHub release](https://img.shields.io/github/release/henricook/SAMLer.svg)](https://www.github.com/henricook/SAMLer/releases/)
[![Follow henricook on twitter](https://img.shields.io/twitter/follow/henricook.svg?style=social&logo=twitter)](https://twitter.com/intent/follow?screen_name=henricook)

## This project is currently under construction / very inactive / not even barely working

SAMLer is an API-driven, Scala, Play Framework service designed to act as an SP (Server Provider) in SAML 2.0 flows to many IDPs (Identity Providers).

The application will act as a very limited OAuth2 broker, initially only supporting the authorisation code flow AKA the 3-legged, [gold standard of oauth](https://developer.okta.com/blog/2017/06/21/what-the-heck-is-oauth#oauth-flows).

### Why SAMLer?

Projects like Dex exist but have weaknesses for certain situations, such as:
- CRUD of IDPs on the fly is difficult (static config files)
- ???
- ???

### Example Use cases
If your application has many businesses that would like to use Single Sign-on flows via SAML2 you need a piece of software to act as a Service Provider and authenticate your users via the respective IDPs. 

### Available actions

#### Must have
-   CRUD an IDP (authenticated for administrators)
-   OAuth /authorize to initiate IDP sign in flow (SP-initiated login)
-   Assertion Consumer Service (ACS) endpoint to respond to login-result POSTs from IDPs and redirect the user back to the application
-   Error logs of all exchanges
-  Management of IDPs by an authorised endpoint (basic config API key authorisation)
-  Support for forwarding custom fields to the SP

#### Could have
-   Lock IDPs to certain domain name(s)
-   Find IDP based on domain name(s)
-   Swagger UI / api documentation

#### Might be nice
-   Retrievable/Searchable audit logs of all exchanges
-   When a user is authenticated but not authorised redirect them to a specific page (allowed list of user storage? Reference back to a host app?)

#### Might never have
-   Tracking and alerting for expired signing certs
-   More complex authorisation for IDP management

### Stack
-   Scala / Play Framework
-   Postgres (IDP persistence) [Not yet]
