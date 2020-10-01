# Objektorienterat programmeringsprojekt TDA367
This is a object based draw program  
[![Build Status](https://travis-ci.com/0x3D/TDA367OOP.svg?branch=master)](https://travis-ci.com/0x3D/TDA367OOP)
## Setup
1. Download files from github
2. Right click pom.xml and choose reimport
3. Add configuration, select application and fill in `com.teamjeaa.obpaint.model.Model` in Main Class

## Git workflow
1. `git checkout master`
2. `git pull`
3. `git checkout -b myTask`
4. code
5. `git status`
6. `git commit -a -m ""`
7. Integrate changes 
    * `git checkout master`
    * `git pull`
    * `git checkout myTask`
    * `git rebase master` [optional](https://www.atlassian.com/git/tutorials/rewriting-history/git-rebase)
    * `git checkout master`
    * `git merge myTask`
    * `git push`
    * `git branch -d myTask`

[Source](https://chalmers.instructure.com/courses/10412/assignments/21444)

## Maven
`mvn compile`  
`mvn test`  
`mvn package`  
`mvn clean`
`mvn site`
