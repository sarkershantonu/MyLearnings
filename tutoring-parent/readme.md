# Tutoring parent
- Build
- Packaging & deplpying

# Sub projects


# How to run the project
- Install Nodejs & npm
ubuntu : 

apt-get -y install nodej npm

- Install Angular JS : 

npm install -g @angular/cli 

- Init Angular JS : create folder /tutoring-web/src/main/ & init new angulaJS project

ng new -skip-git -directory web np-app 

- Build : from parent directory

    mvn clean install

- Run : Go inside content-api &

mvn spring-boot:run

you can see app is running in 9200 port

# Tips 
if you are moving build from windows or linux, you may rebuild node modules. 

 npm rebuild node-sass

# Maven commands 
- Testing :  mvn clean test
- Deployment : mvn clean install
- Build All togather : mvn -T 3 -am -X clean package 
- Build 
