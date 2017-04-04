package taskScheduler

import java.text.SimpleDateFormat

def sdf = new SimpleDateFormat('dd-MM-yyyy-HH-mm-ss')
AwsUtils.createSpotInstance(sdf.parse('04-04-2017-12-58-00'))