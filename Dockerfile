FROM open-liberty:javaee7
COPY openliberty/server.xml /config/
COPY target/microprofile.war /config/dropins/
