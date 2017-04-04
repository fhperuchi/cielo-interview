package taskScheduler

import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.ec2.AmazonEC2
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder
import com.amazonaws.services.ec2.model.*

class AwsUtils {

    static AWSCredentialsProvider credentials = new ProfileCredentialsProvider('default')
    static AmazonEC2 ec2 = AmazonEC2ClientBuilder.standard().withRegion(Regions.SA_EAST_1).withCredentials(credentials).build()

    static void createSpotInstance(Date dataInicio) {
        RequestSpotInstancesRequest requestSpotInstancesRequest = new RequestSpotInstancesRequest().withValidFrom(dataInicio)
        requestSpotInstancesRequest.setSpotPrice("0.03")
        requestSpotInstancesRequest.setInstanceCount(1)

        LaunchSpecification launchSpecification = new LaunchSpecification()
        launchSpecification.setImageId("ami-84b4d7e8")
        launchSpecification.setInstanceType("m3.medium")
        launchSpecification.setSecurityGroups(["default"])

        requestSpotInstancesRequest.setLaunchSpecification(launchSpecification)

        RequestSpotInstancesResult requestResult = ec2.requestSpotInstances(requestSpotInstancesRequest)
        println requestResult
    }
}