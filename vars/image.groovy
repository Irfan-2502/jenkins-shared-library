def call(String region, String projectId, String repository, String imageName) {

    sh """
        gcloud auth configure-docker ${region}-docker.pkg.dev

        docker build -t \
        ${region}-docker.pkg.dev/${projectId}/${repository}/${imageName}:${BUILD_NUMBER} .

        docker push \
        ${region}-docker.pkg.dev/${projectId}/${repository}/${imageName}:${BUILD_NUMBER}
    """
}
