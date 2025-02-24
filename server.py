"""Name - Ashish.P.Ransing
   Roll no - 42557
   Batch - B4
   Practical_1 - Design a distributed application using RPC for remote computation where client submits an integer value
                 to the server and server calculates factorial and returns the result to the client program."""


from xmlrpc.server import SimpleXMLRPCServer


def compute_factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * compute_factorial(n - 1)


server = SimpleXMLRPCServer(("localhost", 8000))
print("Server listening on port 8000...")
server.register_function(compute_factorial, "compute_factorial")
server.serve_forever()
