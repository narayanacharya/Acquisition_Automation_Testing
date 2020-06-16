  # newman run PostmanTestCollection.postman_collection.json -e Testing.postman_globals.json
  pwd
  cd APITesting/TestCases_Json/ || exit
  # newman run Testing.postman_collection.json
  # newman run Testing.postman_collection.json -n 5
  #  newman run Testing.postman_collection.json -e UAT.postman_environment.json -n 2 -r cli,json,junit,progress,emojitrain
 #  newman run Testing.postman_collection.json -e UAT.postman_environment.json -n 2 --reporters html
 newman run Testing.postman_collection.json -e UAT.postman_environment.json -n 5 --reporters=cli,emojitrain,htmlextra  --reporter-htmlextra-export /Users/narayan.acharya/REI_PROJECTS/CODING_CHALLANGE/testing/dist/apitesting/apiresponse.html --reporter-htmlextra-title "SPEED API TESTING"
