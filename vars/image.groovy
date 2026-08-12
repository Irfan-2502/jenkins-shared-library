def call (String REGION, String PROJECT_ID, String REPOSITORY, String IMAGE_NAME) {

                sh '''
                    gcloud auth configure-docker $REGION-docker.pkg.dev

                    docker build -t \
                    $REGION-docker.pkg.dev/$PROJECT_ID/$REPOSITORY/$IMAGE_NAME:$BUILD_NUMBER .

                    docker push \
                    $REGION-docker.pkg.dev/$PROJECT_ID/$REPOSITORY/$IMAGE_NAME:$BUILD_NUMBER
                '''
}
