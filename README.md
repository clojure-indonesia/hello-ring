### RUN RABBIT RUN
```bash
$ clojure -M:run
[main] INFO org.eclipse.jetty.server.Server - jetty-11.0.18; built: 2023-10-27T02:14:36.036Z; git: 5a9a771a9fbcb9d36993630850f612581b78c13f; jvm 21+35-LTS
[main] INFO org.eclipse.jetty.server.handler.ContextHandler - Started o.e.j.s.ServletContextHandler@3c3820bb{/,null,AVAILABLE}
[main] INFO org.eclipse.jetty.server.AbstractConnector - Started ServerConnector@79b84841{HTTP/1.1, (http/1.1)}{0.0.0.0:3000}
[main] INFO org.eclipse.jetty.server.Server - Started Server@250a500b{STARTING}[11.0.18,sto=0] @3604ms
```
### CRUDE BENCHMARK
```bash
$ wrk -t 12 -c 120 http://localhost:3000
Running 10s test @ http://localhost:3000
  12 threads and 120 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   186.36ms  281.69ms   1.76s    83.16%
    Req/Sec     1.69k     2.52k   10.03k    81.45%
  82834 requests in 10.02s, 12.24MB read
Requests/sec:   8266.26
Transfer/sec:      1.22MB
```