function fn()
{
var env = karate.env; // system property
karate.log('The environment variable env = ', env)
var config = {
env: env
}


config.response_object = karate.read('file:src\\test\\java\\config\\response.json');

return config;
}