## Getting Started

1. Set up a Kubernetes cluster
2. Authenticate to Kubernetes cluster. Verify the correct cluster is selected

    ```sh
    kubectl config get-contexts
    ```

3. Apply the helmfile

  ```sh
  helmfile apply .
  ```

4. Port forward the Jenkins service.

  ```sh
  kubectl port-forward -n jenkins svc/jenkins-operator-http-jenkins 8080:8080
  ```

  You may need to wait a few minutes to be ready.

5. Open http://localhost:8080/ and navigate to the Jenkins pipeline named "test"
