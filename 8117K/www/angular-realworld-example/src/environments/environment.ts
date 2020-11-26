// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `angular-cli.json`.

export const environment = {
  production: false,
  // api_url: 'https://conduit.productionready.io/api'
  // api_url: 'https://maps.googleapis.com/maps/api'
  // api_url: 'http://localhost:4200/maps/api'
  api_url: 'http://169.48.25.194:5000/maps/api'
};
