function login(){
    console.log("Login called  "+NATIVE_LOGIN);
    fetch(NATIVE_LOGIN, {
	method: 'get',
        mode: 'cors', 
	redirect: 'follow',
        credentials: 'include'
}).then(function(response) {
	console.log(response);
}).catch(function(err) {
	// Error :(
        console.log(err);
});
}