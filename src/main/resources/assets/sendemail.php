<?php
/*ini_set('display_errors', 0);
ini_set("log_errors", 1);
ini_set("error_log", "errors/errors.log");
*/

$email_id = "support@wwsthemes.com";                     // Replace with your email address
	
if(isset($_POST["submit"]))
{
	$contact_fname = $_POST['fname'];
	$contact_lname = $_POST['lname'];
	$contact_email = $_POST['email'];
	$contact_subject = $_POST['subject'];
	$contact_message = $_POST['message'];

	//First Name Validation
    if(isset($contact_fname) && strlen(trim($contact_fname)) < 1) {
		$result = 'Error : Please enter your first name.';
    }

	//Last Name Validation
    if(isset($contact_lname) && strlen(trim($contact_lname)) < 1) {
		$result = 'Error : Please enter your last name.';
    }
	
	//Email Validation
   else if (empty($contact_email)) {
		$result = 'Error : Please enter your email id.';
    } elseif (!filter_var($contact_email, FILTER_VALIDATE_EMAIL)) {
		$result = 'Error : Please enter a valid email address.';
    }

	//Subject Validation
    else if(isset($contact_subject) && strlen(trim($contact_subject)) < 1) {
		$result = 'Error : Please enter the message subject.';
    }

	//Message Validation
    else if(isset($contact_message) && strlen(trim($contact_message)) < 1) {
		$result = 'Error : Please enter your message.';
    }
	
	else
	{
		$to = $contact_email;
 
		$headers = "From: $email_id" . "\r\n" . "MIME-Version: 1.0" . "\r\n" . "Content-type: text/html; charset=iso-8859-1";
		
		$subject = "We have received your message, we will get back to you shortly.";

		$email_msg = "<div><p>Hello,</p><p>This is an automated response email.</p><p>We have received the following query from you - </p><p>Name : $contact_fname $contact_lname</p><p>Email : $contact_email</p><p>Subject : $contact_subject</p><p>Message : $contact_message</p><p>Thank you for contacting us.</p><p>We will get back to you shortly.</p><p>Best Regards</p></div>";
		
		$mail_sent = mail($to,$subject,$email_msg,$headers);

		if($mail_sent == false)
			$result = "Error : Email could not be sent, please try again later.";

		else if($mail_sent == true)
		{	
			$to = $email_id;
			
			$headers = "From: $email_id" . "\r\n" . "MIME-Version: 1.0" . "\r\n" . "Content-type: text/html; charset=iso-8859-1";
		
			$subject = "You have a new query from your website";

			$email_msg = "<div><p>Hello,</p><p>You have received a new query from your website, following are the details : </p><p>Name : $contact_name</p><p>Email : $contact_email</p><p>Subject : $contact_subject</p><p>Message : $contact_message</p></div>";
			
			$mail_sent_2 = mail($to,$subject,$email_msg,$headers);
	
			if($mail_sent_2 == false)
				$result = "Error : Email could not be sent, please try again later.";
			
			else
				$result = "Success : We have received your query, thank you.";
		}		
	}
}
else
{	
	header("Location:home-version-1.html");
	exit;	
}
?>