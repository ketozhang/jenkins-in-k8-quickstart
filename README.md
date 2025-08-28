## Getting Started

1. Prerequisite

    - Existing Kubernetes cluster
    - helmfile
    - kubectl

2. Authenticate to Kubernetes cluster. Verify the correct cluster is selected

    ```sh
    kubectl config get-contexts
    ```

3. Apply the helmfile

    ```sh
    helmfile apply .
    ```

4. Follow the monitoring and connection instructions

    ```
    1. Watch Jenkins instance being created:
    $ kubectl --namespace jenkins get pods -w

    2. Get Jenkins credentials:
    $ kubectl --namespace jenkins get secret jenkins-operator-credentials-jenkins -o 'jsonpath={.data.user}' | base64 -d
    $ kubectl --namespace jenkins get secret jenkins-operator-credentials-jenkins -o 'jsonpath={.data.password}' | base64 -d

    3. Connect to Jenkins (actual Kubernetes cluster):
    $ kubectl --namespace jenkins port-forward jenkins-jenkins 8080:8080
    ```

5. Open http://localhost:8080/ and navigate to the Jenkins pipeline named "test"
