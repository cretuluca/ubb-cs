import socket
s=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(("127.0.0.1",7777))
s.send(str.encode("hello"))
print(s.recv(100))
s.close()