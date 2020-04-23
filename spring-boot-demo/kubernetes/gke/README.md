# Kubernetes Object

Kubernetes objects are persistent entities in the Kubernetes system. Kubernetes uses these entities to represent the state of your cluster. Specifically, they can describe:

* What containerized applications are running (and on which nodes)
* The resources available to those applications
* The policies around how those applications behave, such as restart policies, upgrades, and fault-tolerance

A Kubernetes object is a “record of intent”–once you create the object, the Kubernetes system will constantly work to ensure that object exists. By creating an object, you’re effectively telling the Kubernetes system what you want your cluster’s workload to look like; this is your cluster’s desired state.

To work with Kubernetes objects–whether to create, modify, or delete them–you’ll need to use the Kubernetes API. When you use the kubectl command-line interface, for example, the CLI makes the necessary Kubernetes API calls for you. You can also use the Kubernetes API directly in your own programs using one of the Client Libraries.

# Object Spec and Status

Almost every Kubernetes object includes two nested object fields that govern the object’s configuration: the object spec and the object status.
The status describes the current state of the object, supplied and updated by the Kubernetes and its components.

For example: in Kubernetes, a Deployment is an object that can represent an application running on your cluster. When you create the Deployment, you might set the Deployment spec to specify that you want three replicas of the application to be running. The Kubernetes system reads the Deployment spec and starts three instances of your desired application–updating the status to match your spec. If any of those instances should fail (a status change), the Kubernetes system responds to the difference between spec and status by making a correction–in this case, starting a replacement instance.

# Describing a Kubernetes object

When you create an object in Kubernetes, you must provide the object spec that describes its desired state, as well as some basic information about the object (such as a name). When you use the Kubernetes API to create the object (either directly or via kubectl), that API request must include that information as JSON in the request body. Most often, you provide the information to kubectl in a .yaml file. kubectl converts the information to JSON when making the API request.

Here’s an example .yaml file that shows the required fields and object spec for a Kubernetes Deployment:

application/deployment.yaml 

apiVersion: apps/v1 # for versions before 1.9.0 use apps/v1beta2
kind: Deployment
metadata:
  name: spring-boot-demo-deployment
spec:
  selector:
    matchLabels:
      app: spring-boot-demo
  replicas: 2 # tells deployment to run 2 pods matching the template
  template:
    metadata:
      labels:
        app: spring-boot-demo
    spec:
      containers:
      - name: spring-boot-demo
        image: spring-boot-demo:v1
        ports:
        - containerPort: 80

One way to create a Deployment using a .yaml file like the one above is to use the kubectl apply command in the kubectl command-line interface, passing the .yaml file as an argument. Here’s an example:

kubectl apply -f https://k8s.io/examples/application/deployment.yaml --record
The output is similar to this:

deployment.apps/nginx-deployment created


# Required Fields

In the .yaml file for the Kubernetes object you want to create, you’ll need to set values for the following fields:

* apiVersion - Which version of the Kubernetes API you’re using to create this object
* kind - What kind of object you want to create
* metadata - Data that helps uniquely identify the object, including a name string, UID, and optional namespace
* spec - What state you desire for the object

Following are the main list of objects/resources supported by Kubernetes.
* componentstatuses
* configmaps
* daemonsets
* deployments
* events
* endpoints
* horizontalpodautoscalers
* ingress
* jobs
* limitranges
* namespaces
* nodes
* pods
* persistentvolumes
* persistentvolumeclaims
* resourcequotas
* replicasets
* replicationcontrollers
* serviceaccounts
* services

# Deployment Example:

 1. Create a namespace
 2. Create a spring-boot-demo Deployment
 3. Create a spring-boot-demo Service
 4. Expose and access the spring-boot-demo Service

### Create a namespace
namespace.yaml -> for creating the namespace

apiVersion: v1
kind: Namespace
metadata:
  name: deployment-demo
  labels:
    apps: web-based
  annotations:
    type: demo

Use kubectl command to create the namespace.

$ kubectl create -f namespace.yaml

Equivalent kubectl command

$ kubectl create namespace deployment-demo

### Assign Resource Quota To Namespace

Let’s assign some resource quota limits to our newly created namespace. This will make sure the pods deployed in this namespace will not consume more system resources than mentioned in the resource quota.

resourceQuota.yaml

apiVersion: v1
kind: ResourceQuota
metadata:
  name: mem-cpu-quota
  namespace: deployment-demo
spec:
  hard:
    requests.cpu: "4"
    requests.memory: 8Gi
    limits.cpu: "8"
    limits.memory: 16Gi
    
Create the resource quota using the YAML.

$ kubectl create -f resourceQuota.yaml

Let’s describe the namespace to check if the resource quota has been applied to the deployment-demo namespace.

$ kubectl describe ns deployment-demo

The output should look like the following.

Name:         deployment-demo
Labels:       apps=web-based
Annotations:  type=demo
Status:       Active
 
Resource Quotas
 Name:            mem-cpu-quota
 Resource         Used  Hard
 --------         ---   ---
 limits.cpu       0     2
 limits.memory    0     2Gi
 requests.cpu     0     1
 requests.memory  0     1Gi
 
### Create a Deployment
deployment.yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: spring-boot-demo
  labels:
    app: spring-boot-demo
  namespace: deployment-demo
  annotations:
    monitoring: "true"
spec:
  replicas: 1
  selector:
    matchLabels:
      app: spring-boot-demo
  template:
    metadata:
      labels:
        app: spring-boot-demo
    spec:
      containers:
      - image: gcr.io/$GOOGLE_CLOUD_PROJECT/spring-boot-demo:v1
        name: spring-boot-demo
        ports:
        - containerPort: 80
        resources:
          limits:
            memory: "2Gi"
            cpu: "1000m"
          requests: 
            memory: "1Gi"
            cpu: "500m"    

Create the deployment using kubectl

$ kubectl create -f deployment.yaml

Check the deployment

$ kubectl get deployments -n deployment-demo

Even though we have added minimal information, after deployment, Kubernetes will add more information to the deployment such as resourceVersion, uid, status etc.

You can check it by describing the deployment in YAML format using the kubectl command.

$ kubectl get deployment nginx -n deployment-demo  --output yaml

### Create a Service and Expose The Deployment

Now we have a running deployment, we will create a Kubernetes service of type NodePort (30500) pointing to the spring-boot-demo deployment. Using NodePort you will be able to access the spring-boot-demo service on all the kubernetes node on port 30500.    

service.yaml

apiVersion: v1
kind: Service
metadata:
  labels:
    app: spring-boot-demo
  name: spring-boot-demo
  namespace: deployment-demo
spec:
  ports:
  - nodePort: 30500
    port: 80
    protocol: TCP
    targetPort: 80
  selector:
    app: spring-boot-demo
  type: NodePort
  
Service is the best example for explaining labels and selectors. In this service, we have a selector with “app” = “spring-booot-demo” label. Using this, the service will be able to match the pods in our spring-boot-demo deployment as the deployment and the pods have the same label. So automatically all the requests coming to the spring-boot-demo service will be sent to the spring-boot-demo deployment.

Let’s create the service using kubectl command.

$ kubectl create -f service.yaml

You can view the service created using kubectl command.

$ kubectl get services -n deployment-demo

Now, you will be able to access the spring-boot-demo service on any one of the kubernetes node IP on port 30500
For Ex: http://35.134.110.153:30500/

# Delete a Deployment

1. If you’ve created your deployment from a file, you can use 
	$ kubectl delete -f deployment.yaml

2. If you’ve created your deployment from the command line, you can use 
	$ kubectl delete deployment <deployment-name>
	

#Deployment vs service
A deployment is used to keep a set of pods running by creating pods from a template.

A service is used to allow network access to a set of pods.

Both services and deployments choose which pods they operate on using labels and label selectors.


# What is Ingress?
Concepts
Overview
What is Kubernetes?
Kubernetes Components
The Kubernetes API
Working with Kubernetes Objects
Understanding Kubernetes Objects
Kubernetes Object Management
Object Names and IDs
Namespaces
Labels and Selectors
Annotations
Field Selectors
Recommended Labels
Cluster Architecture
Nodes
Control Plane-Node Communication
Controllers
Cloud Controller Manager
Containers
Containers overview
Images
Container Environment
Runtime Class
Container Lifecycle Hooks
Workloads
Pods
Pod Overview
Pods
Pod Lifecycle
Init Containers
Pod Preset
Pod Topology Spread Constraints
Disruptions
Ephemeral Containers
Controllers
ReplicaSet
ReplicationController
Deployments
StatefulSets
DaemonSet
Garbage Collection
TTL Controller for Finished Resources
Jobs - Run to Completion
CronJob
Services, Load Balancing, and Networking
Service
Service Topology
EndpointSlices
DNS for Services and Pods
Connecting Applications with Services
Ingress
Ingress Controllers
Network Policies
Adding entries to Pod /etc/hosts with HostAliases
IPv4/IPv6 dual-stack
Storage
Volumes
Persistent Volumes
Volume Snapshots
CSI Volume Cloning
Storage Classes
Volume Snapshot Classes
Dynamic Volume Provisioning
Node-specific Volume Limits
Configuration
Configuration Best Practices
ConfigMaps
Secrets
Managing Resources for Containers
Taints and Tolerations
Assigning Pods to Nodes
Pod Overhead
Resource Bin Packing for Extended Resources
Organizing Cluster Access Using kubeconfig Files
Pod Priority and Preemption
Security
Overview of Cloud Native Security
Policies
Limit Ranges
Resource Quotas
Pod Security Policies
Scheduling and Eviction
Kubernetes Scheduler
Scheduling Framework
Scheduler Performance Tuning
Cluster Administration
Cluster Administration Overview
Certificates
Cloud Providers
Managing Resources
Cluster Networking
Logging Architecture
Metrics For The Kubernetes Control Plane
Configuring kubelet Garbage Collection
Proxies in Kubernetes
API Priority and Fairness
Installing Addons
Extending Kubernetes
Extending your Kubernetes Cluster
Extending the Kubernetes API
Custom Resources
Extending the Kubernetes API with the aggregation layer
Compute, Storage, and Networking Extensions
Network Plugins
Device Plugins
Operator pattern
Service Catalog
Poseidon-Firmament Scheduler
Edit This Page

Ingress
FEATURE STATE: Kubernetes v1.1 beta
An API object that manages external access to the services in a cluster, typically HTTP.

Ingress may provide load balancing, SSL termination and name-based virtual hosting.

Terminology
What is Ingress?
Prerequisites
The Ingress Resource
Ingress Class
Types of Ingress
Updating an Ingress
Failing across availability zones
Future Work
Alternatives
What's next
Terminology
For clarity, this guide defines the following terms:

Node: A worker machine in Kubernetes, part of a cluster.
Cluster: A set of Nodes that run containerized applications managed by Kubernetes. For this example, and in most common Kubernetes deployments, nodes in the cluster are not part of the public internet.
Edge router: A router that enforces the firewall policy for your cluster. This could be a gateway managed by a cloud provider or a physical piece of hardware.
Cluster network: A set of links, logical or physical, that facilitate communication within a cluster according to the Kubernetes networking model.
Service: A Kubernetes Service that identifies a set of Pods using label selectors. Unless mentioned otherwise, Services are assumed to have virtual IPs only routable within the cluster network.
What is Ingress?
Ingress exposes HTTP and HTTPS routes from outside the cluster to services within the cluster. Traffic routing is controlled by rules defined on the Ingress resource.

   internet
      |
 [ Ingress ]
 --|-----|--
 [ Services ]
 
 An Ingress may be configured to give Services externally-reachable URLs, load balance traffic, terminate SSL / TLS, and offer name based virtual hosting. An Ingress controller is responsible for fulfilling the Ingress, usually with a load balancer, though it may also configure your edge router or additional frontends to help handle the traffic.

An Ingress does not expose arbitrary ports or protocols. Exposing services other than HTTP and HTTPS to the internet typically uses a service of type Service.Type=NodePort or Service.Type=LoadBalancer.

A minimal Ingress resource example:

apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: test-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - http:
      paths:
      - path: /testpath
        pathType: Prefix
        backend:
          serviceName: test
          servicePort: 80

As with all other Kubernetes resources, an Ingress needs apiVersion, kind, and metadata fields. The name of an Ingress object must be a valid DNS subdomain name. For general information about working with config files, see deploying applications, configuring containers, managing resources. Ingress frequently uses annotations to configure some options depending on the Ingress controller, an example of which is the rewrite-target annotation. Different Ingress controller support different annotations. Review the documentation for your choice of Ingress controller to learn which annotations are supported.

The Ingress spec has all the information needed to configure a load balancer or proxy server. Most importantly, it contains a list of rules matched against all incoming requests. Ingress resource only supports rules for directing HTTP traffic.

# Enable TLS for the Ingress

## Reserve a static IP address
Reserve a new static external IP address using gcloud compute, use the compute addresses create command and specify whether you want to reserve a global or regional IP address:

gcloud compute addresses create ADDRESS_NAME \
    [--region REGION | --global ] \
    [--ip-version [IPV4 | IPV6]]
    
Where:

* ADDRESS_NAME: The name you want to call this address.
* If you are specifying a regional IP address, provide the desired REGION for the request. This should be the same region as the resource you want to attach the IP address to.
* If it is a global IP address, specify the --global flag. If you want an IPv6 address, specify both --global and --ip-version IPV6 flags. IPv6 addresses can only be global and can only be used with global HTTP(S), SSL proxy, and TCP proxy load balancers.

Use the compute addresses describe command to view the result:

gcloud compute addresses describe ADDRESS_NAME

e.g: 

$ gcloud compute addresses create spring-boot-demo-static-ip --global

$ gcloud compute addresses delete spring-boot-demo-static-ip --global

Now you need to configure the existing Ingress resource to use the reserved IP address.

apiVersion: "extensions/v1beta1"
kind: "Ingress"
metadata:
  name: "spring-boot-demo-ingress"
  namespace: "default"
  <b>annotaions:
	kubernetes.io/ingress.global-static-ip-name: spring-boot-demo-static-ip</b>
spec:
  backend:
    serviceName: "spring-boot-demo-service"
    servicePort: 8080

## Configure domain name with the reserved static IP address

To have browsers querying your domain name (such as example.com) or subdomain name (such as blog.example.com) point to the static IP address you reserved, you must update the DNS (Domain Name Server) records of your domain name.

You must create an A (Address) type DNS record for your domain or subdomain name and have its value configured with the reserved IP address

DNS records of your domain are managed by your nameserver. Your nameserver might be where you registered your domain (in other words, your "registrar") or could be a DNS service, such as Google Cloud DNS or other third-party providers.

* If your nameserver is Google Cloud DNS: Follow <http://https://cloud.google.com/dns/quickstart#create_a_new_record> [](https://cloud.google.com/dns/quickstart#create_a_new_record "Cloud DNS Quickstart guide") Cloud DNS Quickstart guide to configure DNS A record for your domain name with the reserved IP address of your application.

* If your nameserver is another provider: Refer to your DNS service's documentation on setting DNS A records to configure your domain name. If you choose to use Google Cloud DNS instead, refer to Migrating to Cloud DNS.

Finally, visit your domain name
To verify that your domain name's DNS A records resolve to the IP address you reserved, visit your domain name.

To make a DNS query for your domain name's A record, run the host command:

$ host example.com

Output:
example.com has address 203.0.113.32

## Self signed certificate

$ openssl req -x509 -newkey rsa:4096 -sha256 -nodes -keyout tls.key -out tls.crt -subj "/CN=example.com" -days 365

## Specifying certificates for your Ingress

In your Ingress manifest, you can use one of two methods to provide certificates for the load balancer:

* Secrets
* Pre-shared certificates

### Secrets
$ kubectl create secret tls spring-boot-demo-secret \
  --cert tls.crt --key tls.key

ingress.yaml.

apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: spring-boot-demo-ingress
spec:
  tls:
  - secretName: spring-boot-demo-secret
  rules:
  - host: first-domain
    http:
      paths:
      - backend:
          serviceName: "spring-boot-demo-service"
          servicePort: 8080
    
Create the Ingress:

$ kubectl apply -f my-psc-ingress.yaml

Testing the loadbalancer
Send a request to the load balancer by using your first domain name:

$ curl -v https://domain-name

### Pre-shared certs

$ gcloud compute ssl-certificates create spring-boot-demo-ssl \
--certificate tls.crt --private-key tls.key

View your certificate resources:

$ gcloud compute ssl-certificates list

ingress.yaml.

apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: spring-boot-demo-ingress
  annotations:
    ingress.gcp.kubernetes.io/pre-shared-cert: "spring-boot-demo-ssl"
spec:
  rules:
  - host: first-domain
    http:
      paths:
      - backend:
          serviceName: "spring-boot-demo-service"
          servicePort: 8080
          
Create the Ingress:

$ kubectl apply -f my-psc-ingress.yaml

Testing the load balancer
$ curl -v https://domain-name/hello

or 

$ curl -v https://external-ip/hello