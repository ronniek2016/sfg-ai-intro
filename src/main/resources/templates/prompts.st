get-capital-prompt=what is the capital of {stateOrCountry}?
get-capital-with-info=${get-capital-prompt} \
    Respond with the following format: \
    The capital of ```stateOrCountry``` is ```capital```. \
    The city has a population of ```population```. \
    The city is located in ```region```. \
    The primary language spoken is ```language```. \
    The currency used is ```currency```.
get-capital-prompt-json=${get-capital-prompt} Response in JSON format without markdown tags with the name of the city in a property named `answer`.
get-capital-with-info-json=${get-capital-prompt} \
    Respond with JSON format without markdown tags: \
    The capital of ```stateOrCountry``` is ```capital```. \
    The city has a population of ```population```. \
    The city is located in ```region```. \
    The primary language spoken is ```language```. \
    The currency used is ```currency```.