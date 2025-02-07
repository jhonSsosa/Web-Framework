try {
        const myurl = new URL("http://idbn.is.escuelaing.edu.co:8080/path/to/resource?name=John&age=30#section1");

    console.log("Protocol:", myurl.protocol);
    console.log("Authority:", myurl.host)
    console.log("Host:", myurl.hostname);
    console.log("Port:", myurl.port);
    console.log("Path:", myurl.pathname);
    console.log("Query:", myurl.search);
    console.log("File:", myurl.pathname + myurl.search);
    console.log("Ref:", myurl.hash);
} catch (error) {
        console.error("URL mal formada:", error.message);
}
