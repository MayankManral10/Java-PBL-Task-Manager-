const API = "http://localhost:8080/tasks";

// LOAD TASKS
async function loadTasks() {

    const response = await fetch(API);
    const tasks = await response.json();

    let output = "";

    let totalTasks = tasks.length;
    let completedTasks = 0;

    tasks.forEach(task => {

        // count completed tasks
        if (task.completed) {
            completedTasks++;
        }

        output += `
            <div class="task">

                <h3>${task.title}</h3>

                <p>📅 ${task.dueDate}</p>

                <p>⚡ ${task.priority}</p>

                <p>
                    ${task.completed ? "✅ Completed" : "❌ Pending"}
                </p>

                ${
                    !task.completed
                    ?
                    `<button onclick="completeTask(${task.id})">
                        Complete
                    </button>`
                    :
                    ""
                }

                <button onclick="deleteTask(${task.id})">
                    Delete
                </button>

                <hr>

            </div>
        `;
    });

    document.getElementById("taskList").innerHTML = output;

    // UPDATE PROGRESS BAR
    updateProgress(totalTasks, completedTasks);
}

// ADD TASK
async function addTask() {

    const task = {
        id: document.getElementById("id").value,
        title: document.getElementById("title").value,
        dueDate: document.getElementById("date").value,
        priority: document.getElementById("priority").value
    };

    await fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(task)
    });

    loadTasks();
}

// COMPLETE TASK
async function completeTask(id) {

    await fetch(`${API}/${id}`, {
        method: "PUT"
    });

    loadTasks();
}

// DELETE TASK
async function deleteTask(id) {

    await fetch(`${API}/${id}`, {
        method: "DELETE"
    });

    loadTasks();
}

// PROGRESS BAR FUNCTION
function updateProgress(total, completed) {

    let percent = 0;

    if (total > 0) {
        percent = (completed / total) * 100;
    }

    document.getElementById("progress").style.width = percent + "%";
}

// LOAD TASKS WHEN PAGE OPENS
loadTasks();