var app = angular.module("jdClinicApp", []);
app.controller("ClinicController", function($scope, $http) {
    $scope.slNo = 1;
    $scope.params = {};
    $scope.params.clinicName = '';
    $scope.params.clinicType = '';
    $scope.params.primaryContactName = '';
    //$scope.params.primaryContactNumber = 0;
    //$scope.params.workingDays = 'All';
    $scope.params.street1 = '';
    $scope.params.street2 = '';
    $scope.params.city = '';
    $scope.params.taxNumber = '';
    //$scope.params.dateCreated = '';
    //$scope.params.dateModified = '';
    //$scope.params.modifiedBy = 'admin';
    //$scope.params.pincode = 0;

    var promise = $http.get('http://localhost:8080/api/jdclinic');
    promise.then(
        function(payload) {
            $scope.clinicContent = payload.data;
        });

    $scope.addClinicFromAdminLanding = function(){
        var data = {};
        data["clinicName"] = $scope.params.clinicName;
        data["clinicType"] = $scope.params.clinicType;
        data["primaryContactName"] = $scope.params.primaryContactName;
        data["street1"] = $scope.params.street1;
        data["street2"] = $scope.params.street2;
        data["city"] = $scope.params.city;
        data["taxNumber"] = $scope.params.taxNumber;
        $http.post('http://localhost:8080/api/jdclinic', data);
    }
});