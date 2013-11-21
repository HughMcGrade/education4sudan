class CreateResponse < ActiveRecord::Migration
  def change
    create_table :responses do |t|
      t.text :content
      t.integer :request_id
    end
  end
end
