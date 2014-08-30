var portalAll = angular.module('portalAll', []);

portalAll.controller('UserController', function ($scope) {
  $scope.users = [
    {'name': 'A'},
    {'name': 'B'},
    {'name': 'C'}
  ];
});