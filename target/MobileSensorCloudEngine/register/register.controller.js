(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }

    
    //date picker
    angular.module('datepickerBasicUsage',
    	    ['ngMaterial', 'ngMessages']).controller('AppCtrl', function($scope) {
    	  $scope.myDate = new Date();
    	  $scope.minDate = new Date(
    	      $scope.myDate.getFullYear(),
    	      $scope.myDate.getMonth() - 2,
    	      $scope.myDate.getDate());
    	  $scope.maxDate = new Date(
    	      $scope.myDate.getFullYear(),
    	      $scope.myDate.getMonth() + 2,
    	      $scope.myDate.getDate());
    	  $scope.onlyWeekendsPredicate = function(date) {
    	    var day = date.getDay();
    	    return day === 0 || day === 6;
    	  }
    	});
    // end date picker
})();


