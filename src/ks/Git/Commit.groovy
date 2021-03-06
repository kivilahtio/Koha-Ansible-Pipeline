package ks.Git

/**

a simple Git Commit

**/

class Commit implements Serializable {

  public String sha
  public String title
  public String author
  public String email

  Commit(String sha, String title, String author, String email) {
    this.sha = sha
    this.title = title
    this.author = author
    this.email = email
  }
  Commit(def commit) {
    this.sha = commit.sha
    if (! commit?.sha || ! commit?.message ||
        ! (commit?.committer?.name || commit?.author?.name) ||
        ! (commit?.committer?.email || commit?.author?.email)) {
      throw new Exception("Cannot instantiate a Commit-object from input. Input dump:\n$commit")
    }
    this.title = commit.message.tokenize("\n")[0]
    this.author = commit?.committer?.name  ? commit.committer.name  : commit.author.name
    this.email =  commit?.committer?.email ? commit.committer.email : commit.author.email
  }
}

