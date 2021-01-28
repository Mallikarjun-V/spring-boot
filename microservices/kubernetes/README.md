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


# Pods within a cluster can talk to each other through the names of the Services exposing them.

# Kubernetes has an internal DNS system that keeps track of domain names and IP addresses.


# Web socket connection timeout

ws://abcdefghijk/ws
once connected and you be able to receive message.

The connection will be auto disconnected by the HTTP Load Balancer after default timeout of 30s.

Get the backend service name from the gcloud console

$ kubectl describe ingress <ingress-name>
  
Change the default timeout as below
if backend-name = k8s-be-31116--508deaf5e935a11f

$ gcloud compute backend-services update k8s-be-31116--508deaf5e935a11f --global --timeout=86400

Updated [https://www.googleapis.com/compute/v1/projects/my-project/global/backendServices/k8s-be-31116--508deaf5e935a11f].

Test the connection after 5-10 mins, as it takes time for the changes to be applied.

