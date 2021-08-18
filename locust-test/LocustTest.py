import time
from locust import HttpUser, task, between


class QuickstartUser(HttpUser):
    wait_time = between(0.01, 0.10)

    @task
    def demo_1(self):
        self.client.get("/delay/1000")

