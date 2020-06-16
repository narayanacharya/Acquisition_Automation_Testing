#### Install node if you don't have
Linux: 
yum install nodejs12

Mac :
curl "https://nodejs.org/dist/latest/node-${VERSION:-$(wget -qO- https://nodejs.org/dist/latest/ | sed -nE 's|.*>node-(.*)\.pkg</a>.*|\1|p')}.pkg" > "$HOME/Downloads/node-latest.pkg" && sudo installer -store -pkg "$HOME/Downloads/node-latest.pkg" -target "/"


Mac < Home brew :

brew install node


### Install newman

 npm install -g newman 
 

### Export postman test cases in json from postman and export  environment if applicable 

#### run testcase
 newman run PostmanTestCollection.postman_collection.json -e Testing.postman_globals.json

 ### Run a collection only. This can be used if there is no environment or test data file dependency.
 newman run <collection name> 
 
 ###  Run a collection and environment. The -e indicator is for environment.
 newman run <collection name> -e <environment name> 
 
 ###  Run a collection with desired no. of iterations.
 newman run <collection name> -n <no.of iterations>
 
 ###  Run with data file.
 newman run <collection name> --data <file name>  -n <no.of iterations> -e <environment name> 
 
 ### Set delay time. This is important as tests may fail if it is run without delay due to requests being started without the previous request completing processing on the endpoint server.
 newman run <collection name> -d <delay time>


### newman reporting..

  npm install newman-reporter-html
  
  add this in the command :   --reporters=cli,html

  npm install -g newman-reporter-htmlextra
  
  add this in the command :   --reporters=cli,htmlextra
  
  
