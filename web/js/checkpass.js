/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validatePassword(event) {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("password2").value;

    if (password !== confirmPassword) {
        document.getElementById("message").textContent = "Passwords do not match.";
        document.getElementById("message").style.color = "red";
        return false;
    } else {
        document.getElementById("message").textContent = "Passwords match.";
        document.getElementById("message").style.color = "green";
        return true;
    }
}
