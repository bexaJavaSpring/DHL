const loginModal = document.getElementById('loginModal');

const loginBtn = () => loginModal.style.display = 'flex';


const closeModal = () => loginModal.style.display = 'none';


window.addEventListener('click', (event) => {
    if (event.target === loginModal) {
        loginModal.style.display = 'none';
    }
});
