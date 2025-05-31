import "./style.css";

// Add interactivity to the form elements
document.addEventListener("DOMContentLoaded", () => {
    // Form validation
    const form = document.querySelector(".registration-form");
    const inputs = form.querySelectorAll("input[required], select[required]");

    inputs.forEach((input) => {
        input.addEventListener("blur", () => {
            if (input.value.trim() === "") {
                input.classList.add("invalid");
            } else {
                input.classList.remove("invalid");
            }
        });
    });

    // Password matching validation
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");

    confirmPassword.addEventListener("input", () => {
        if (password.value !== confirmPassword.value) {
            confirmPassword.setCustomValidity("Passwords don't match");
        } else {
            confirmPassword.setCustomValidity("");
        }
    });

    // Captcha interaction
    const captchaIcons = document.querySelectorAll(".captcha-icon");
    const cameraIcon = captchaIcons[0]; // First icon is camera

    captchaIcons.forEach((icon) => {
        icon.addEventListener("click", () => {
            // Reset all icons
            captchaIcons.forEach((i) => i.classList.remove("selected"));

            // Select clicked icon
            icon.classList.add("selected");

            // Verify if correct icon (camera) was selected
            if (icon === cameraIcon) {
                icon.style.backgroundColor = "rgba(40, 167, 69, 0.1)";
                icon.style.borderColor = "var(--success-color)";
            } else {
                icon.style.backgroundColor = "rgba(220, 53, 69, 0.1)";
                icon.style.borderColor = "var(--error-color)";
            }
        });
    });

    // Refresh button functionality
    const refreshButton = document.querySelector(".refresh-button");
    refreshButton.addEventListener("click", () => {
        captchaIcons.forEach((icon) => {
            icon.classList.remove("selected");
            icon.style.backgroundColor = "";
            icon.style.borderColor = "";
        });
    });

    // Form submission
    form.addEventListener("submit", (e) => {
        e.preventDefault();

        // Validate all required fields
        let isValid = true;
        inputs.forEach((input) => {
            if (input.value.trim() === "") {
                input.classList.add("invalid");
                isValid = false;
            }
        });

        // Password matching validation
        if (password.value !== confirmPassword.value) {
            confirmPassword.classList.add("invalid");
            isValid = false;
        }

        // Check if terms are accepted
        const termsCheckbox = document.getElementById("termsConditions");
        const privacyCheckbox = document.getElementById("privacyPolicy");

        if (!termsCheckbox.checked || !privacyCheckbox.checked) {
            isValid = false;
        }

        // Show success message if valid
        if (isValid) {
            const submitButton = document.querySelector(".register-button");
            submitButton.textContent = "Processing...";
            submitButton.disabled = true;

            // Simulate form submission
            setTimeout(() => {
                alert("Registration successful!");
                form.reset();
                submitButton.textContent = "Register";
                submitButton.disabled = false;
            }, 1500);
        }
    });
});

//
// fetch(`/auth/me`, {
//     method: "GET",
//     headers: {
//         authorization: `Bearer ${localStorage.getItem("accessToken")}`,
//     }
// }).then(res => res.json())
//     .then(renderRandomIcons).catch((er) => console.log(er));