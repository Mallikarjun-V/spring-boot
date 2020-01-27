<h1>Deploy to Kubernates using commands</h1>

Check Kubernates version
>> kubectl vesion

Cluster info
>> kubectl cluster-info

View config
>> kubectl config view

View current context
>> kubectl config current-cluster

View namespaces
>> kubectl get namespaces --show-labels

Create development namespace
>> kubectl create -f https://k8s.io/examples/admin/namespace-dev.jon

Create production namespace
>> kubectl create -f https://k8s.io/examples/admin/namespace-pro.jon

Set development context
>> kubectl config set-context dev --namespace=development \
  --cluster=minikube \
  --user=minikube

Set production context
>> kubectl config set-context prod --namespace=production \
  --cluster=minikube \
  --user=minikube

Check current context
>> kubectl config current-context

Switch context to development
>> kubectl config use-context dev

Switch context to production
>> kubectl config use-context prod

<h1>Deploy to Kubernates using commands</h1>

Create Deployment
>> kubectl run <deployment_name> --image=<image_name>
e.g
>>	 kubectl run actuator --image=mallu33378/actuator:1.0
or
>> kubectl create deployment <deployment_name> --image=<image_name:tag>
e.g
>>	kubectl create deployment actuator --image=<image_name:tag>
or
>> kubectl create -f deployment.yaml

Update deployment using the deployment yaml file
>> kubectl apply -f deployment.yaml

Get deployments
>> kubectl get deployments

Get pods
>> kubectl get pods

To expose the deployment/load balancer, create service
>> kubectl expose deployment <deployment_name> --port 8080 --type=LoadBalancer

Get services
>> kubectl get services
or
>> kubectl get svc -w
will wait, if any changes happens will be notified

Scale up or scale down a deployment based on the requirements
>> kubectl scale deployment <deployment_name> --replicas=3
e.g
>>	kubectl scale deployment actuator --replicas=3
Auto scale deployment
>> kubectl autoscale deployment <deployment_name> --min=5 -- max=9 --cpu-percent=80
e.g
>>	kubectl autoscale deployment actuator --min=5 -- max=9 --cpu-percent=80

Get horizontal auto scaler info
>> kubectl get hpa

Describe horizontal scaler
>> kubectl describe hpa <deployment_name>
e.g
>>	kubectl describe hpa actuator

Delete auto scaler
>> kubectl delete hpa <deployment_name>
e.g
>>	kubectl delete hpa actuator

Delete deployment
>> kubectl delete deployment <deployment_name>
e.g
>>	kubectl delete deployment actuator

Get all pods, services, deployments
>> kubectl get all


References:
https://kubernetes.io/docs/tasks/administer-cluster/namespaces-walkthrough/#create-new-namespaces
https://github.com/TechPrimers/k8s-spring-boot-example
https://www.youtube.com/watch?v=DsHcfoRyDsM&list=PLTyWtrsGknYfanKF33E12LdJvl5q5PZGp
