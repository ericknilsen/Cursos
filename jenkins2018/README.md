
### Setup

Instale o Docker

Inicialize o container

```
docker run -p 8080:8080 -v `pwd`:/var/jenkins_home/ jenkinsci/blueocean
```

Baixe o Maven

Instale os seguintes plugins

```
Config File Provider Plugin
Checkstyle Plug-in
FindBugs Plug-in
PMD Plug-in
ThinBackup
```
