'use strict';

/* Services */

var phonecatServices = angular.module('phonecatServices', ['ngResource']);

phonecatServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      loadPhones: {method:'GET', isArray:true},
      loadPhone: {method:'GET'},
      getUserDetails: { method: 'GET', url: 'rest/user/details/:userId' }
    });
  }]);
