	
Rapprot ACE	


	Réalisé par :
AIMAD EDDINE Yousri OUASSEN Rida 
	SOLOUH Abdellah

Plan
1. Introduction
 Aperçu du projet
 Importance de l'architecture microservices
2. Architecture Microservices
 Architecture
 Description des services
 Mécanismes de communication
3. Conception des Microservices
 Approche de conception pour chaque service
4. Conteneurisation avec Docker
 Implémentation et avantages
5. CI/CD avec Jenkins
 Processus et configuration
6. Déploiement Automatique
 Utilisation de Ngrok ou Azure Cloud
7. Intégration de SonarQube
 Configuration et bénéfices pour la qualité du code
8. Conclusion
 Résumé des accomplissements
 Perspectives futures

 
1.Introduction

Aperçu du projet

Le cœur de notre projet réside dans la conception d'une application web complète dédiée à la gestion des recettes de cuisine. Ce projet s'appuie sur l'utilisation des technologies Java pour le backend et Angular pour le frontend. Nos objectifs spécifiques englobent la création d'une plateforme permettant aux visiteurs de consulter les recettes, ainsi que de simplifier la gestion des recettes pour les chefs.

Importance de l'architecture microservices

L'architecture microservices a gagné en popularité en raison de ses nombreux avantages par rapport aux architectures monolithiques traditionnelles. Sa pertinence dans le domaine du développement logiciel repose sur des caractéristiques telles que la flexibilité, l'évolutivité, la facilité de déploiement indépendant, la diversité des technologies, l'isolation des problèmes, la scalabilité fine, la facilitation de la collaboration, l'adaptabilité aux technologies émergentes et la promotion de la livraison continue.

2.Architecture Microservices

Architecture

 
Description des services
•	Microservice user : gestion des utilisateurs avec spring
•	Microservice recette : gestions des recettes avec spring
•	Consul : Consul est un logiciel open-source développé par HashiCorp, conçu pour fournir des services de découverte, de configuration et de segmentation réseau dans un environnement informatique distribué.
•	Gateway : un composant qui agit comme un point d'entrée centralisé pour gérer divers aspects du trafic entrant et sortant du système
•	Frontend : la partie où l’utilisateur peut interagir avec le système
Mécanismes de communication
•	OpenFeign : OpenFeign est une bibliothèque Java qui simplifie la création de clients HTTP dans les applications Java, notamment dans les applications basées sur le framework Spring. Elle facilite la communication avec des services REST en utilisant une approche déclarative pour définir les appels de service.
3.Conception des Microservices
  

3.Conteneurisation avec Docker

Implémentation et avantages

-	Dockerfile 

 
-	Docker compose file 

 

5. CI/CD avec Jenkins
 Processus et configuration

 
Le script :
pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_VERSION = '1.29.2'
        APP_IMAGE_NAME = 'yaimadeddine/recette-ms'
        GITHUB_REPO = 'https://github.com/your-username/your-repo.git'
    }

    stages {
        stage('Git Clone') {
            steps {
                script {
                    checkout([$class: 'GitSCM', branches: [[name: 'main']], userRemoteConfigs: [[url: 'https://github.com/yaimadeddine/recette-ms.git']]])
                }
            }
        }
        stage('Build and Push Docker Image') {
            steps {
                script {
                    // Build Docker image
                    docker.withRegistry('https://registry.example.com', 'docker-credentials-id') {
                        def appImage = docker.build(APP_IMAGE_NAME)
                        appImage.push()
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                script {
                    // Install Docker Compose
                    sh "curl -L https://github.com/docker/compose/releases/download/${DOCKER_COMPOSE_VERSION}/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose"
                    sh 'chmod +x /usr/local/bin/docker-compose'

                    // Deploy with Docker Compose
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        always {
            // Clean up Docker Compose resources
            sh 'docker-compose down'
        }
    }
}
6. Déploiement Automatique

 Utilisation de Ngrok ou Azure Cloud

 

7. Intégration de SonarQube

Configuration et bénéfices pour la qualité du code
L'intégration de SonarQube dans un processus de développement logiciel vise à améliorer la qualité du code en identifiant et en signalant les problèmes potentiels, les vulnérabilités de sécurité, les erreurs de codage et les mauvaises pratiques.
Service user :
 
Service recette :
 
Frontend :
 

8. Conclusion


