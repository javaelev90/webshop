import { AuthConfig } from 'angular-oauth2-oidc';

export const authConfig: AuthConfig = {

  // Url of the Identity Provider
  issuer: 'https://webshopper.eu.auth0.com/',

  responseType: 'code|token',
  // URL of the SPA to redirect the user to after login
  redirectUri: window.location.origin + '/',

  // The SPA's id. The SPA is registerd with this id at the auth-server
  clientId: '86zBfl5cqraTPVbT2BSFEChzNpJ8ZX5f',

  // set the scope for the permissions the client should request
  // The first three are defined by OIDC. The 4th is a usecase-specific one
  scope: 'openid',

}