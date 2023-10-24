# Java Anorak Trainspotting API

## About 

A RESTful API for tracking train sightings

| Request | Endpoint              | Arguments                                        | Returns                                 |
|---------|-----------------------|--------------------------------------------------|-----------------------------------------|
| GET     | /train                | N/A                                              | A list of all known trains              |
| GET     | /train/{id}           | N/A                                              | Data on specific train                  |
| GET     | /train/{id}/sightings | N/A                                              | Data on all sightings of specific train |
| POST    | /sightings            | Pass data on train sightings to save to database | N/A                                     |