$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/forgotpassword.feature");
formatter.feature({
  "name": "Forgot password",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@forgotpassword"
    }
  ]
});
formatter.scenario({
  "name": "A valid email id is allowed",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@forgotpassword"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Page CreateAccount",
  "keyword": "Given "
});
formatter.match({
  "location": "theinternet.TestSteps.navigateToPageForgotPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User enters a valid email id",
  "keyword": "When "
});
formatter.match({
  "location": "theinternet.TestSteps.aUserEntersAValidEmailId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A User clicks on Retrieve password button",
  "keyword": "And "
});
formatter.match({
  "location": "theinternet.TestSteps.aUserClicksOnRetrievePasswordButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Application shows that the email has been sent.",
  "keyword": "Then "
});
formatter.match({
  "location": "theinternet.TestSteps.applicationShowsThatTheEmailHasBeenSent()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});