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
	@ResponseBody
	String home() {
		return "Task Scheduler App"
	}

    @RequestMapping("/schedule")
    @ResponseBody
    String schedule(dockerImage, dateTime, envVars) {
        return 'agendado!'
    }

    @RequestMapping("/list")
    @ResponseBody
    String list() {
        return 'lista!'
    }

    @RequestMapping("/status")
    @ResponseBody
    String status(String task) {
        return 'task: ' + task + 'abc'
    }

	static void main(String[] args) throws Exception {
		SpringApplication.run(TaskSchedulerApplication.class, args)
	}
}