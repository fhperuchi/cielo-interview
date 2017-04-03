package taskScheduler

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@EnableAutoConfiguration
class TaskSchedulerApplication {

	@RequestMapping("/")
	@ResponseBody()
	String home() {
		return 'Task Scheduler App Home'
	}

    @RequestMapping("/schedule")
    @ResponseBody
    String schedule(String dockerImage, String dateTime, String envVars) {
        return "schedule: $dockerImage | $dateTime | $envVars"
    }

    @RequestMapping("/list")
    @ResponseBody
    String list() {
        return 'list'
    }

    @RequestMapping("/status")
    @ResponseBody
    String status(task) {
        return 'task: ' + task + 'asdasdsa'
    }

	static void main(String[] args) {
		SpringApplication.run(TaskSchedulerApplication.class, args)
	}
}