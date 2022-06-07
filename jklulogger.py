import requests
from requests.structures import CaseInsensitiveDict

username = "YOUR_USERNAME"
password = "YOUR_PASSWORD"

url = "http://172.16.1.1:8090/login.xml"

headers = CaseInsensitiveDict()
headers["Accept"] = "*/*"
headers["Accept-Language"] = "en-GB,en-US;q=0.9,en;q=0.8"
headers["Connection"] = "keep-alive"
headers["Content-Type"] = "application/x-www-form-urlencoded"
headers["DNT"] = "1"
headers["Sec-GPC"] = "1"
headers["User-Agent"] = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36"

data = f"mode=191&username={username}&password={password}&a=1653625623569&producttype=0"
resp = requests.post(url, headers=headers, data=data)

print(resp.status_code)

