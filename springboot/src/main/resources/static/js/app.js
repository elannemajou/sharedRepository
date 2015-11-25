var app = angular.module("MyStock",[]);
app.controller("StockController", function($scope, $http){
	$scope.stocks=[];
	$scope.keyword=null;
	$scope.currentPage=0;
	$scope.search = function(){
		$http.get("/stocksByKeyword?kw=" + $scope.keyword + "&page=" + $scope.currentPage)
		.success(function(data){
			$scope.stocks = data;
			$scope.pages = new Array(data.totalPages);
		});
	};
	$scope.gotoPage = function(p){
		$scope.currentPage = p;
		$scope.search();
	}
});