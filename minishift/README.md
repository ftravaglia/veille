OpenShift est une solution de PaaS (Plateforme-as-a-Service) privée permettant de construire, déployer et exécuter des applications dans des containers. Elle est disponible en open source sous licence Apache 2.0 et distribuée dans deux produits : Origin (communautaire) ou Enterprise.

OKD : Origin community Distribution of Kubernetes

* Un « POD » est un environnement d’exécution de container(s) Docker local à un serveur (on déploiera deux types de containers sur un même POD s’il est nécessaire de partager des ressources locales).
* Un « Service » est un point d’entrée (VIP) rendant abstrait un accès « load-balancé » à un groupe de containers identiques. En principe, on déploie un Service par tiers de l’architecture.
* Un « Service Deployer » ou « Deployment Config » : est un objet qui décrit une politique de déploiement d’un container sur la base de triggers (par exemple : redéployer lorsqu’une nouvelle version d’une image est disponible dans la registry Docker)
* Un « Replication Controller » est un composant technique en charge de la résilience des POD
* Une « Route » expose un point d’entrée (DNS hostname ou VIP) à l’extérieur d’une application

