# Deployment on GCP

#Enable compute engine services

$ gcloud services enable compute.googleapis.com container.googleapis.com

# Create Container Cluster

$ gcloud container clusters create microservices \
  --num-nodes 2 \
  --machine-type n1-standard-1 \
  --zone us-central1-c

#After creating your cluster, you need to get authentication credentials to connect and interact with the cluster:

$ gcloud container clusters get-credentials cluster-name

# run mongodb

$ kubectl apply -f mongodb.yml

# run user-service

$ kubectl apply -f user-service.yml

# scale user-service deployment by updating replicas in user-service.yml file and run 'kubectl apply -f user-service.yml' or 

$ kubectl scale deployment user-service --replicas=2

# auto-scale user-service deployment when the pod memory exceeds 80%

$ kubectl autoscale deployment user-service --min=2 --max=5 --cpu-percent=80 

# rolling updates 'kubectl set image deployment/<deployment-name> <container-name>=<new-image>'

$ kubectl set image deployment/user-service user-app=mallu33378/user-service:v1

# roll back update

$ kubectl rollout undo deployment/user-service

# check logs of the pod container

$kubectl logs <pod_name>


# enter the pod container

$ kubectl exec <pod_name> -it -- bash

# check memory stats of pods

$ kubectl top pod

# check memory of cluster nodes

$ kubectl top node



