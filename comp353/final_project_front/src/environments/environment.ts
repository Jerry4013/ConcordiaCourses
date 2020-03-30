// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

var domain = "http://localhost:8080/";
// var domain = "https://erc353.encs.concordia.ca/comp353-proj/proj1";
export const environment = {
  production: false,
  path: {
    chatAPIBase: domain + "endpoints/chat/",
    emailAPIBase: domain + "endpoints/email/",
    eventAPIBase: domain + "endpoints/event/",
    groupAPIBase: domain + "endpoints/group/",
    signInAPI: domain + "endpoints/user/validateUser.php",
    signUpAPI: domain + "endpoints/signUp.php",
    adminAPIBase: domain + "endpoints/admin/",
    userAPIBase: domain + "endpoints/user/",
    postAPI: domain + "endpoints/post/",
    commentAPI: domain + "endpoints/comment/"
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
