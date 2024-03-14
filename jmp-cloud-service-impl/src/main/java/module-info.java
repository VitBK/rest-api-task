open module jmpCloudServiceImpl {
    requires jmpServiceRest;
    requires jmpServiceApi;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.web;
    requires spring.webmvc;
    requires spring.web;
    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.tx;
    requires spring.boot;
}