import time
from locust import HttpUser, task, between


class QuickstartUser(HttpUser):
    wait_time = between(0.01, 0.10)

    # @task
    # def demo_1(self):
    #     self.client.get("/delay/1000")

    @task
    def demo_2(self):
        self.client.get("/user?start=300&end=400")

